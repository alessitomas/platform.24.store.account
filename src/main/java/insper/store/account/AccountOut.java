package insper.store.account;

import java.io.Serializable;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(fluent = true, chain = true)
public record AccountOut (
    String id,
    String name,
    String email
) implements Serializable{
    
}
