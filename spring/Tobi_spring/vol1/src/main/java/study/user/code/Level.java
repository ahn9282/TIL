package study.user.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Level {
    BASIC(1),
    SILVER(2),
    GOLD(3),
    ;
    private final int value;
    public static Level valueOf(int value){
        switch(value){
            case 1: return BASIC;
            case 2: return SILVER;
            case 3: return GOLD;
            default:
                throw new AssertionError("Unknown value : " + value);
        }
    }

}
