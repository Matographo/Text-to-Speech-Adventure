package de.ttsa.ConsoleGame;

public class OpCode extends ConsoleLoadingSyntax {

    protected final String REGEX_SAY = "^((\"([a-zA-Z0-9\\s\\?\\!])+\")|([a-zA-Z]+[a-zA-Z0-9]*|[\\d]?)){1}([,]((\"([\\w\\s\\?\\!]?)+\")|([a-zA-Z0-9]+)+))*";
    protected final String REGEX_ROOM = "([a-zA-Z][\\w\\s]*:[\\d]+)";
    protected final String REGEX_NUMBER_VARIABLE = "([a-zA-Z][\\w]*:[\\d]+)";
    protected final String REGEX_STRING_VARIABLE = "([a-zA-Z][\\w]*:[\\w\\s\\!\\?]+)";
    protected final String REGEX_IF_NUMBER = "(^[n](([a-zA-Z]+[\\w]*)|([\\d]*))([\\<]|[\\>]|[\\<][\\=]|[\\>][=]|[\\=][\\=]|[\\!][\\=])(([a-zA-Z]+[\\w]*)|([\\d]*)){1}(([\\+\\-\\*\\/])(([a-zA-Z]+[\\w]*)|([\\d]*)))*)";
    protected final String REGEX_IF_STRING = "(^[s]([a-zA-Z]+[\\w]*)([\\=][\\=])(([a-zA-Z]+[\\w]*)|([\"][\\w\\s]*[\"])))";
    protected final String REGEX_IF_INPUT = "(^[i]([\\(]([\"]([a-zA-Z][\\w]*|[\\'][a-zA-Z][\\w]*[\\']|[\\[][a-zA-Z][\\w]*[\\]])+(\\!\\!([a-zA-Z][\\w]*|[\\'][a-zA-Z][\\w]*[\\']|[\\[][a-zA-Z][\\w]*[\\]]))*[\"])+[\\)]";
    // protected final String REGEX_INPUT;
    // protected final String REGEX_STR_VARDEC;
    // protected final String REGEX_DEBUG;
    // protected final String REGEX_SAVE;
    // protected final String REGEX_LOAD;
    // protected final String REGEX_EXIT;
    // protected final String REGEX_LOOP;
    // protected final String REGEX_LOOP_BREAKER;
    // protected final String REGEX_SET;
    // protected final String REGEX_ACTION;
    // protected final String REGEX_ACTION_CALL;
    
}