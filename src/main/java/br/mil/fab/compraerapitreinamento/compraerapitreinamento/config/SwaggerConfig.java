package br.mil.fab.compraerapitreinamento.compraerapitreinamento.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(password = @OAuthFlow(tokenUrl = "${keycloak.login}")))
public class SwaggerConfig implements WebMvcConfigurer {

	@Value("${app.name}")
	private String appName;

	@Value("${app.version}")
	private String appVersion;

	@Value("${app.description}")
	private String appDescription;

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("compraer").pathsToMatch("/api/**").build();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		String serverDate = sdf.format(new Date());
		return new OpenAPI().info(new Info().title(appName)
				.description(appDescription.concat(" - ".concat(serverDate))).version(appVersion).contact(contact()));

	}

	private Contact contact() {
		Contact contact = new Contact();
		contact.setEmail("pargacapp@fab.mil.br");
		contact.setName("1T Parga, CCA-RJ");
		contact.setUrl(
				"http://www.fab.mil.br/organizacoes/mostra/67/CENTRO%20DE%20COMPUTA%C3%87%C3%83O%20DE%20AERON%C3%81UTICA%20DO%20RIO%20DE%20JANEIRO");
		return contact;
	}

}
