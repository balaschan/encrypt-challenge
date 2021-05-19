package com.wonderlabs.challenge.encryption.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class FileUtil {



    /**
     *
     * @param resourceFilename
     * @param keyName
     * @param value
     * @throws IOException
     */
    public static void writeProperty(Resource resourceFilename, String keyName, String value) throws IOException {
        //Loading Properties
        InputStream in = resourceFilename.getInputStream();
        Properties props = new Properties();
        props.load(in);
        in.close();

        //Writing properties under source
        Path resourceDirectory = Paths.get("src","main","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        FileOutputStream out = new FileOutputStream(absolutePath+ File.separator + resourceFilename.getFilename());
        props.setProperty(keyName, value);
        props.store(out, "key write " + keyName);
        out.close();
    }


}
