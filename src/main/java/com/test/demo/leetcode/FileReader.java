package com.test.demo.leetcode;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.queryparser.classic.QueryParser;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author :zjk
 * @Date :Create in 14:32 2020-11-14
 * @Description
 **/
public class FileReader {
    public static void main(String[] args) throws IOException, ParseException {
//        FileInputStream inputStream = new FileInputStream("C:\\Users\\JK Zhu\\Desktop\\POINT.FNM"); // ---（1）
//
//        InputStreamReader iReader = new InputStreamReader(inputStream,"gbk");   // ---（2）
//
//        BufferedReader br = new BufferedReader(iReader);
//
//        String data="";
//
//        while((data=br.readLine())!=null){
//
//            System.out.println(data);
//
//        }


        //其中，第(1)行可以用下面的代替

//        File file = new File("d:/test/gdcell.txt");
//
//        FileInputStream inputStream = new FileInputStream(file);


//        String directoryPath = "C:\\Users\\JK Zhu\\Desktop\\index";
//        Directory directory = FSDirectory.open(Paths.get(directoryPath));
//        IndexWriterConfig config = new IndexWriterConfig();
//        Document doc = new Document();
//        StringField f1 = new StringField("name1", "smi smith steve ted teddy terry", Field.Store.YES);
//
//        StringField f2 = new StringField("name2", "what are you doing", Field.Store.YES);
//
//        StringField f3 = new StringField("name3", "how do you do", Field.Store.YES);
//
//        doc.add(f1);
//        doc.add(f2);
//        doc.add(f3);
//
//        Document doc2 = new Document();
//        StringField f4 = new StringField("name4", "smi smith steve ted teddy terry", Field.Store.YES);
//        StringField f5 = new StringField("name5", "what are you doing", Field.Store.YES);
//        StringField f6 = new StringField("name6", "how do you do", Field.Store.YES);
//        doc.add(f4);
//        doc.add(f5);
//        doc.add(f6);
////        File path = new File("/Users/healchow/Documents/index");
////        Directory directory = FSDirectory.open(Paths.get(directoryPath));
//        IndexWriter writer = new IndexWriter(directory, config);
//
//        writer.addDocument(doc);
//        writer.addDocument(doc2);
//        writer.close();

        //01.
        Path path=Paths.get("C:\\Users\\JK Zhu\\Desktop\\");
        Directory directory=FSDirectory.open(path);
        IndexReader indexReader= DirectoryReader.open(directory);
        //索引查询工具
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        String word="name";
        QueryParser queryParser=new QueryParser("filename",new StandardAnalyzer());
        Query query=queryParser.parse(word);
        TopDocs topDocs = indexSearcher.search(query, 10);

        TotalHits count = topDocs.totalHits;
        System.out.println("总记录数："+count);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc item:scoreDocs) {
            int docid = item.doc; //文档编号
            Document document = indexReader.document(docid);
            String filename = document.get("filename");
            System.out.println(filename);
        }
    }
}
