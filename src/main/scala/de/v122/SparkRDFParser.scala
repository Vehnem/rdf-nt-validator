package de.v122

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import org.dbpedia.databus.derive.io.rdf.NTripleParser

import javax.servlet.http.HttpServletRequest
import org.apache.commons.io.IOUtils
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam}

import java.nio.charset.StandardCharsets
import scala.io.Source

@Controller
@RequestMapping(value = Array())
class SparkRDFParser {

  @RequestMapping(value = Array("parser"), method = Array(RequestMethod.GET))
  def index(model: Model): String = {
    "index"
  }

  @RequestMapping(value = Array("report"), method = Array(RequestMethod.POST))
  def post(@RequestParam(name = "ntriples") ntriples: String, model: Model): String = {


    val inputStream = new ByteArrayInputStream(ntriples.getBytes(StandardCharsets.UTF_8))

    val tripleOS = new ByteArrayOutputStream
    val reportOS = new ByteArrayOutputStream

    NTripleParser.parse(inputStream, tripleOS, reportOS, removeWarnings = true)

    val validTriples = Source.fromBytes(tripleOS.toByteArray, "UTF-8").mkString
    println("validTriples", validTriples)

    model.addAttribute("validTriples", validTriples)
    model.addAttribute("faultTriples", Source.fromBytes(reportOS.toByteArray, "UTF-8").mkString)

    tripleOS.close()
    reportOS.close()
    inputStream.close()

    "results"

    //    views.html.results(
    //      Source.fromBytes(tripleOS.toByteArray, "UTF-8").mkString,
    //      Source.fromBytes(reportOS.toByteArray, "UTF-8").mkString
    //    )
    //
  }


}
