package enums;

public enum NewsType {
    RETIREMENT(1),
    TRANSFER(2),
    BALLON_DOR(3);

    private int code;

    NewsType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
