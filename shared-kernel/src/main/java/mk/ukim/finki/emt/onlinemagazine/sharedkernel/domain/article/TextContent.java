package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class TextContent implements ValueObject {

    private final String TextContent;

    private TextContent(@NonNull String textContent) {
        TextContent = textContent;
    }

    public TextContent() {
        TextContent = null;
    }

    public static TextContent createTextContent (@NonNull String textContent) {
        return new TextContent(textContent);
    }

    @Override
    public String toString() {
        return "TextContent{" +
                "TextContent='" + TextContent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextContent tc = (TextContent) o;
        return TextContent.equals(tc.TextContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TextContent);
    }
}
