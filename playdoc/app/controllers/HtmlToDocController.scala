package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.libs.json._
import play.api.data.Forms._

import java.io.File;
import java.io.{File, FileInputStream, FileOutputStream}

import org.apache.commons.io.FileUtils;

import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.RFonts;
import org.docx4j.utils.ResourceUtils;

import sun.misc.BASE64Encoder;

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HtmlToDocController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  val dataDoc = Form(
    "html" -> text
  )

  def create() = Action { implicit request =>

    val html = dataDoc.bindFromRequest.get
    val code_html = s"""${html}"""

    var file_path = System.getProperty("user.dir") + "/templates/contract.docx"
    val file = generateFile(code_html, file_path)

    val fileInputStream = new FileInputStream(file)
    val bytes = new Array[Byte](file.length.toInt)
    fileInputStream.read(bytes)
    fileInputStream.close()
      
    val encoded_docx = encodeBase64(bytes)

    val response = Json.toJson(s"{encoded_docx: ${encoded_docx}}")

    Ok( response )
  }


  def generateFile(code_html: String, file_path: String) : File = {
    val wordMLPackage = WordprocessingMLPackage.createPackage()
    val XHTMLImporter = new XHTMLImporterImpl(wordMLPackage)
    var file = new File(file_path)

    wordMLPackage.getMainDocumentPart().getContent().addAll( XHTMLImporter.convert(code_html, null) )
    wordMLPackage.save(file)
    return file;
  }

  def encodeBase64(bytes: Array[Byte]) : String = {
    val enconded = new BASE64Encoder()
          .encode(bytes)
          .replace("\n", "")
          .replace("\r", "")
    return enconded;
  }
}
