package project.java.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ipershin on 31.08.17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    private int code;
    private String message;
    private Error error;
    private T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return success(null);
    }

    public static <T> Result<T> success(final T data) {
        return new Result<T>(Message.SUCCESS.getCode(), null, data);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<T>(code, message, null);
    }

    public static <T> Result<T> error(int code, String message, Exception ex) {
        Result result = new Result<T>(code, message,null);

        if (ex != null) {
            List<String> trace = Arrays.stream(ex.getStackTrace()).map(item -> item.toString()).collect(Collectors.toList());
            Error error = new Error("asd as", trace.toArray(new String[trace.size()]));
            result.setError(error);
        }

        return result;
    }

    public static <T> Result<T> error(Message message, Exception ex) {
        return error(message.getCode(), message.getText(), ex);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Error {
        private String text;
        private String[] trace;
    }

}
