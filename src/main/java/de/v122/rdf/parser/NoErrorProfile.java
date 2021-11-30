package de.v122.rdf.parser;


import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.apache.jena.iri.IRI;
import org.apache.jena.riot.system.*;
import org.apache.jena.riot.tokens.Token;
import org.apache.jena.sparql.core.Quad;

class NoErrorProfile implements ParserProfile {
    private final ParserProfile base;

    NoErrorProfile(ParserProfile base) {
        this.base = base;
    }

    public String resolveIRI(String uriStr, long line, long col) {
        return base.resolveIRI(uriStr, line, col);
    }

    public void setBaseIRI(String baseIRI) {
        base.setBaseIRI(baseIRI);
    }

//    public IRI makeIRI(String uriStr, long line, long col) {
//        return base.createURI(uriStr, line, col);
//    }

//    public void setIRIResolver(IRIResolver resolver) {
//        base. (resolver);
//    }

    public Triple createTriple(Node subject, Node predicate, Node object, long line, long col) {
        return base.createTriple(subject, predicate, object, line, col);
    }

    public Quad createQuad(Node graph, Node subject, Node predicate, Node object, long line, long col) {
        return base.createQuad(graph, subject, predicate, object, line, col);
    }

    public Node createURI(String uriStr, long line, long col) {
        return base.createURI(uriStr, line, col);
    }

    public Node createTypedLiteral(String lexical, RDFDatatype datatype, long line, long col) {
        return base.createTypedLiteral(lexical, datatype, line, col);
    }

    public Node createLangLiteral(String lexical, String langTag, long line, long col) {
        return base.createLangLiteral(lexical, langTag, line, col);
    }

    public Node createStringLiteral(String lexical, long line, long col) {
        return base.createStringLiteral(lexical, line, col);
    }

    public Node createBlankNode(Node scope, String label, long line, long col) {
        return base.createBlankNode(scope, label, line, col);
    }

    public Node createBlankNode(Node scope, long line, long col) {
        return base.createBlankNode(scope, line, col);
    }

    public Node createTripleNode(Node subject, Node predicate, Node object, long line, long col) {
        return null;
    }

    public Node createTripleNode(Triple triple, long line, long col) {
        return null;
    }

    public Node createGraphNode(Graph graph, long line, long col) {
        return null;
    }

    public Node createNodeFromToken(Node scope, Token token, long line, long col) {
        return base.createNodeFromToken(scope, token, line, col);
    }

    public Node create(Node currentGraph, Token token) {
        return base.create(currentGraph, token);
    }

    public boolean isStrictMode() {
        return false;
    }

    public PrefixMap getPrefixMap() {
        return base.getPrefixMap();
    }

    public ErrorHandler getErrorHandler() {
        return null;
    }

    public FactoryRDF getFactorRDF() {
        return base.getFactorRDF();
    }
}