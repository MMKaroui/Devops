package net.youssfi.backend.loader;

import jakarta.annotation.PostConstruct;
/*import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
//import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
@Profile("ai")
@Component
public class DataLoader {

   /* @Value("classpath:docs/CryptoWhiteBook.pdf")
    private Resource pdfResource;

    private final VectorStore vectorStore;

    public DataLoader(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadData() {
        try {
            // 1. Read PDF into documents
            PagePdfDocumentReader reader = new PagePdfDocumentReader(pdfResource);
            List<Document> documents = reader.get();

            // 2. Split documents into chunks
            TextSplitter textSplitter = new TokenTextSplitter();
            List<Document> chunks = textSplitter.split(documents);

            // 3. Send chunks directly to vector store
            // No need to access private content field
            vectorStore.accept(chunks);

            System.out.println("Data loaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
