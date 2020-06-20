package io.github.robwin.swagger2markup.petstore;


import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2019/12/20
 */
public class CreateApiDoc {


    public static void main(String[] args) throws MalformedURLException {

        String url = "http://192.168.2.241:8092/v2/api-docs";
       // Path outputFile = Paths.get("build/swagger");
        Path outputFile = Paths.get("C:\\Users\\admin\\Desktop\\api");
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
        Swagger2MarkupConverter converter =
                Swagger2MarkupConverter.from(new URL(url))
                        .withConfig(config).build();
        converter.toFile(outputFile);
    }
}
