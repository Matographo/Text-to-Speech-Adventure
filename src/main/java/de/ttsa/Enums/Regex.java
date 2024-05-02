package de.ttsa.Enums;

public enum Regex {
    SAY_OPCODE("^((\"([a-zA-Z0-9\\s\\?\\!])+\")|([a-zA-Z]+[a-zA-Z0-9]*|[\\d]?)){1}([,]((\"([\\w\\s\\?\\!]?)+\")|([a-zA-Z0-9]+)+))*"), 
    ROOM_OPCODE("([a-zA-Z][\\w\\s]*:[\\d]+)"), 
    ROOM_JUMPER_OPCODE("([a-zA-Z]\\w*)"), 
    NUMBER_DEC_OPCODE("([a-zA-Z][\\w]*:[\\d]+)"), 
    STR_DEC_OPCODE("([a-zA-Z][\\w]*:[\\w\\s\\!\\?]*)"), 
    IF_NUMBER_OPCODE("(^(([a-zA-Z]+[\\w]*)|([\\d]*))([\\<]|[\\>]|[\\<][\\=]|[\\>][=]|[\\=][\\=]|[\\!][\\=])(([a-zA-Z]+[\\w]*)|([\\d]*)){1}(([\\+\\-\\*\\/])(([a-zA-Z]+[\\w]*)|([\\d]*)))*)"), 
    IF_INNER_BRECKETS_OPCODE("(-)?(([a-zA-Z]+[\\w]*)|([\\d]))*(([\\+\\-\\*\\/]){1}(-)?(([a-zA-Z]+[\\w]*)|([\\d])))*"), 
    IF_STRING_OPCODE("(([a-zA-Z]+[\\w]*)|(\"[a-zA-Z]+[\\w]*)\")((\\=\\=)|(\\!\\=))(([a-zA-Z]+[\\w]*)|(\"[a-zA-Z]+[\\w]*)\")"), 
    IF_INPUT_OPCODE("(~?-?\\[(-?\\{(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))*\\}\\*\\(\\d*\\))(-?\\{(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))*\\}\\*\\(\\d*\\))*\\]\\*\\(\\d*\\))(~?-?\\[(-?\\{(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))*\\}\\*\\(\\d*\\))(-?\\{(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))(-?(\\\"[\\w.,!?]*\\\"|'[a-zA-Z][\\w]*'|@[a-zA-Z][\\w]*@)\\*\\(\\d*\\))*\\}\\*\\(\\d*\\))*\\]\\*\\(\\d*\\))*"), 
    STR_VARDEC_OPCODE("([a-zA-Z]\\w*)\\:(([a-zA-Z]\\w*)|(\"[\\w\\s\\?\\!]*\"))(\\,([a-zA-Z]\\w*)|\\,(\"[\\w\\s\\?\\!]*\"))*"), 
    DEBUG_OPCODE("(([a-zA-Z]\\w*)|(\"[\s]?([a-zA-Z][\\w\\s]*)?\"))(,(\"[\s]?([a-zA-Z][\\w\\s]*)?\")|,([a-zA-Z]\\w*))*"), 
    EXIT_OPCODE("[0]|[1]"), 
    LOOP_OPCODE("(true)|\\d+|([a-zA-Z][\\w]*)"), 
    SET_OPCODE("^([a-zA-Z][\\w]*)[\\:]([\"][a-zA-Z][\\w]*[\"]|[a-zA-Z][\\w*])([\\,]([\"][a-zA-Z][\\w]*[\"]|[a-zA-Z][\\w]*))*"), 
    ACTION_OPCODE("([a-zA-Z]\\w*\\:)((-)|([sn][a-zA-Z]\\w*)([\\,]([sn][a-zA-Z]\\w*))*)(\\:\\d*)"), 
    ACTION_CALL_OPCODE("([a-zA-Z]\\w*\\:)((-)|([a-zA-Z]\\w*)|(\"([\\w\\s])*\")|\\d*)(\\,((-)|([a-zA-Z]\\w*)|(\"([\\w\\s])*\")|\\d*))*"), 
    
    SAY_CODE("('[a-zA-Z]\\w*'|[\\w\\s!?]*)*"), 
    ROOM_CODE(""), 
    ROOM_JUMPER_CODE(""), 
    NUMBER_DEC_CODE(""), 
    STR_DEC_CODE(""), 
    IF_NUMBER_CODE(""), 
    IF_INNER_BRECKETS_CODE(""), 
    IF_STRING_CODE(""), 
    IF_INPUT_CODE(""), 
    STR_VARDEC_CODE(""), 
    DEBUG_CODE(""), 
    EXIT_CODE(""), 
    LOOP_CODE(""), 
    SET_CODE(""), 
    ACTION_CODE(""), 
    

    VALIDE_NAME("([a-zA-Z][\\w]*)"), 
    VALIDE_NUMBER("^[-]?[0-9]+$"), 
    CALCULATABLE("^(([-]?([0-9]))*|([-]?([a-zA-Z]+[a-zA-Z0-9])))*(?:[-+*/][-]?[a-zA-Z0-9]+)*$");

    private String command;

    Regex(String regex) {
        this.command = regex;
    }

    @Override
    public String toString() {
        return command;
    }
}
