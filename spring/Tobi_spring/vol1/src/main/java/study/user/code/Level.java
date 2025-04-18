package study.user.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Level {
    GOLD(3, null),
    SILVER(2, GOLD),
    BASIC(1, SILVER),
    ;
    private final int value;
    private Level next;

    public int intValue(){
        return value;
    }
    public Level nextLevel(){
        return this.next;
    }

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
