package project.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, TemplateException {
        String json = """
                    {
                        "messages":[
                            {
                                "index":"ABC-1",
                                "projectNumber":324,
                                "date":"2021-11-11 23:22",
                                "guid": "xxxxx-xxxx-xxxx"
                            }
                        ]
                    }
                """;
        var data = Map.of("messages", List.of(Map.of("index", "ABC-1", "projectNumber", "324", "date", "2021-11-11 23:22", "guid", "xxxxx-xxxx-xxxx")));


        ObjectMapper mapper = new ObjectMapper();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setDefaultEncoding("UTF-8");

        StringTemplateLoader template = new StringTemplateLoader();
        String templateText = """
                Внимание!
                <br/>
                <#list messages as message>
                Сформирован в дело "${message["index"]}" документ  <a style="font-size: 15px; font-weight: 400; color: #7C7AEE; cursor: pointer;" href="http://portal.apps.itfbgroup.local/document-and-storage/list/{guid}/view"> № ${message["projectNumber"]} </a> (номер в ЕСМ), от "${message["date"]}" (дата создания документа в ЕСМ)  содержащий невалидную УКЭП.
                </#list>
                </br>
                Необходимо произвести проверку: загрузить валидную подпись по данному документу или исключить документ из  электронного дела.
                                """;
        template.putTemplate("greetingTemplate", templateText);
        cfg.setTemplateLoader(template);

        Template temp = cfg.getTemplate("greetingTemplate");
        Writer out = new OutputStreamWriter(System.out);
        temp.process(data, out);
    }
}
