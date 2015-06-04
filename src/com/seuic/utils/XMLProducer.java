package com.seuic.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;

import com.seuic.entities.Product;
import com.seuic.entities.XMLData;

public class XMLProducer {
    
    
    public static boolean generateXMLFile (String path,XMLData data)  {
        
        try {
            File file = new File(path);
            FileOutputStream fileos = new FileOutputStream(file);
            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(fileos, "UTF-8");
            serializer.startDocument("UTF-8", null);
            serializer.startTag(null, "DataList"); 
            serializer.attribute(null,"corpName",data.getCorpName());
            serializer.attribute(null, "dataType", data.getDataType());
            serializer.attribute(null, "version", data.getVersion());
            serializer.attribute(null,"xmlns:xsi",data.getXmlns_xsi());
            serializer.attribute(null, "xsi:noNamespaceSchemaLocation", data.getXsi_noNamespaceSchemaLocation());
            
            for (Product product : data.getProducts()) {
                serializer.startTag(null, "Product");
                serializer.attribute(null, "productName", product.getProductName());
                serializer.attribute(null, "pzwh", product.getPzwh());
                serializer.startTag(null, "Batch");
                serializer.attribute(null, "batchNo", product.getBatchNo());
                serializer.attribute(null, "specification", product.getSpecification());
                serializer.attribute(null, "minPackUnit", product.getMinPackUnit());
                serializer.attribute(null, "minTagUnit", product.getMinTagUnit());
                serializer.attribute(null, "tagPackRatio", product.getTagPackRatio());
                serializer.attribute(null, "tagRatio", product.getTagRatio());
                serializer.attribute(null, "produceDate", product.getProduceDate());
                serializer.attribute(null, "operator", product.getOperator());
                serializer.attribute(null, "oprDate", product.getOprDate());
                serializer.attribute(null, "count", product.getCount());
                serializer.attribute(null, "countUnit", product.getCountUnit());
                for(String code : product.getCode()) {
                    serializer.startTag(null, "Data");
                    serializer.attribute(null, "code", code);
                    serializer.endTag(null, "Data"); 
                }
                serializer.endTag(null, "Batch");
                serializer.endTag(null, "Product");
            }
            serializer.endTag(null, "DataList");
            serializer.endDocument();
            serializer.flush();
            fileos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
