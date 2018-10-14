package in.niraj.spring.server.versioning;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

@ControllerAdvice
public class AdapterAdvice implements ResponseBodyAdvice<Versioned> {
    private static final String PROTOCOL_VERSION_HEADER = "X-Protocol-Version";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        return Arrays.asList(((Class<?>) methodParameter.getGenericParameterType()).getInterfaces()).contains(Versioned.class);
    }

    @Override
    public Versioned beforeBodyWrite(
            Versioned versioned,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {

        String version = serverHttpRequest.getHeaders().getFirst(PROTOCOL_VERSION_HEADER);

        if (null == version) throw new RuntimeException(String.format("Missing '%s' header.", PROTOCOL_VERSION_HEADER));

        return versioned.toVersion(parseInt(version));
    }
}
