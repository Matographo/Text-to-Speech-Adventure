package de.ttsa.Logic.Enums;

public enum OpCodeRegex {
    SAY("^((\"([a-zA-Z0-9\\s\\?\\!])+\")|([a-zA-Z]+[a-zA-Z0-9]*|[\\d]?)){1}([,]((\"([\\w\\s\\?\\!]?)+\")|([a-zA-Z0-9]+)+))*"), 
    ROOM("([a-zA-Z][\\w\\s]*:[\\d]+)"), 
    ROOM_JUMPER("([a-zA-Z]\\w*)"), 
    NUMBER_DEC("([a-zA-Z][\\w]*:[\\d]+)"), 
    STR_DEC("([a-zA-Z][\\w]*:[\\w\\s\\!\\?]*)"), 
    IF_NUMBER("(^(([a-zA-Z]+[\\w]*)|([\\d]*))([\\<]|[\\>]|[\\<][\\=]|[\\>][=]|[\\=][\\=]|[\\!][\\=])(([a-zA-Z]+[\\w]*)|([\\d]*)){1}(([\\+\\-\\*\\/])(([a-zA-Z]+[\\w]*)|([\\d]*)))*)"), 
    IF_INNER_BRECKETS("(-)?(([a-zA-Z]+[\\w]*)|([\\d]))*(([\\+\\-\\*\\/]){1}(-)?(([a-zA-Z]+[\\w]*)|([\\d])))*"), 
    IF_STRING("(([a-zA-Z]+[\\w]*)|(\"[a-zA-Z]+[\\w]*)\")((\\=\\=)|(\\!\\=))(([a-zA-Z]+[\\w]*)|(\"[a-zA-Z]+[\\w]*)\")"), 
    IF_INPUT("(^([\\(]([\"]([a-zA-Z][\\w]*|[\\'][a-zA-Z][\\w]*[\\']|[\\[][a-zA-Z][\\w]*[\\]])+(\\!\\!([a-zA-Z][\\w]*|[\\'][a-zA-Z][\\w]*[\\']|[\\[][a-zA-Z][\\w]*[\\]]))*[\"])+[\\)]))"), 
    STR_VARDEC("([a-zA-Z]\\w*)\\:(([a-zA-Z]\\w*)|(\"[\\w\\s\\?\\!]*\"))(\\,([a-zA-Z]\\w*)|\\,(\"[\\w\\s\\?\\!]*\"))*"), 
    DEBUG("(([a-zA-Z]\\w*)|(\"[\s]?([a-zA-Z][\\w\\s]*)?\"))(,(\"[\s]?([a-zA-Z][\\w\\s]*)?\")|,([a-zA-Z]\\w*))*"), 
    EXIT("[0]|[1]"), 
    LOOP("(true)|\\d+|([a-zA-Z][\\w]*)"), 
    SET("^([a-zA-Z][\\w]*)[\\:]([\"][a-zA-Z][\\w]*[\"]|[a-zA-Z][\\w*])([\\,]([\"][a-zA-Z][\\w]*[\"]|[a-zA-Z][\\w]*))*"), 
    ACTION("([a-zA-Z]\\w*\\:)((-)|([sn][a-zA-Z]\\w*)([\\,]([sn][a-zA-Z]\\w*))*)(\\:\\d*)"), 
    ACTION_CALL("([a-zA-Z]\\w*\\:)((-)|([a-zA-Z]\\w*)|(\"([\\w\\s])*\")|\\d*)(\\,((-)|([a-zA-Z]\\w*)|(\"([\\w\\s])*\")|\\d*))*"), 
    VALIDE_NAME("([a-zA-Z][\\w]*)"), 
    VALIDE_NUMBER("^[-]?[0-9]+$"), 
    CALCULATABLE("^(([-]?([0-9]))*|([-]?([a-zA-Z]+[a-zA-Z0-9])))*(?:[-+*/][-]?[a-zA-Z0-9]+)*$");

    private String command;

    OpCodeRegex(String regex) {
        this.command = regex;
    }

    @Override
    public String toString() {
        return command;
    }
}
