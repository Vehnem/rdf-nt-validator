package de.v122

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

import org.apache.jena.irix.IRIx
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.riot.{Lang, RDFDataMgr}

object Snippet extends App {

  val triple = "<http://wikidata.dbpedia.org/resource/Q9398047> <http://www.w3.org/2002/07/owl#sameAs> <http://pl.dbpedia.org/resource/￼> ."

  val model = ModelFactory.createDefaultModel()
  RDFDataMgr.read(model,new ByteArrayInputStream(triple.getBytes(StandardCharsets.UTF_8)),"http://ex.org/",Lang.NTRIPLES)

  model.write(System.out, "NTriples")


}
