package de.oglimmer.unixsocket;


import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.message.BasicRequestLine;

import java.net.URI;


public class HttpGetUnix extends HttpEntityEnclosingRequestBase {

    public final static String METHOD_NAME = "GET";
    private final String filename;

    public HttpGetUnix(String filename) {
        super();
        this.filename = filename;
    }

    public HttpGetUnix(final String filename, final URI uri) {
        super();
        this.filename = filename;
        setURI(uri);
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid.
     */
    public HttpGetUnix(final String filename, final String uri) {
        super();
        this.filename = filename;
        setURI(URI.create(uri));
    }

    @Override
    public RequestLine getRequestLine() {
        final ProtocolVersion ver = getProtocolVersion();
        return new BasicRequestLine(METHOD_NAME, filename, ver);
    }

    public String getFilename() {
        return filename;
    }


    @Override
    public String getMethod() {
        return METHOD_NAME;
    }

}


