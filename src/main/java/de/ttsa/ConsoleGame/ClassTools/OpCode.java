package de.ttsa.ConsoleGame.ClassTools;

public class OpCode extends ConsoleLoadingSyntax {

    

// ------------------------------  REGEX  ------------------------------



    protected final String REGEX_SAY = "^((\"([a-zA-Z0-9\\s\\?\\!])+\")|([a-zA-Z]+[a-zA-Z0-9]*|[\\d]?)){1}([,]((\"([\\w\\s\\?\\!]?)+\")|([a-zA-Z0-9]+)+))*";
    protected final String REGEX_ROOM = "([a-zA-Z][\\w\\s]*:[\\d]+)";
    protected final String REGEX_ROOM_JUMPER = "([a-zA-Z]\\w*)";
    protected final String REGEX_NUMBER_VARIABLE = "([a-zA-Z][\\w]*:[\\d]+)";
    protected final String REGEX_STRING_VARIABLE = "([a-zA-Z][\\w]*:[\\w\\s\\!\\?]+)";
    protected final String REGEX_IF_NUMBER = "(^(([a-zA-Z]+[\\w]*)|([\\d]*))([\\<]|[\\>]|[\\<][\\=]|[\\>][=]|[\\=][\\=]|[\\!][\\=])(([a-zA-Z]+[\\w]*)|([\\d]*)){1}(([\\+\\-\\*\\/])(([a-zA-Z]+[\\w]*)|([\\d]*)))*)";
    protected final String REGEX_IF_STRING = "(^([a-zA-Z]+[\\w]*)([\\=][\\=])(([a-zA-Z]+[\\w]*)|([\"][\\w\\s]*[\"])))";
    protected final String REGEX_IF_INPUT = "(^([\\(]([\"]([a-zA-Z][\\w]*|[\\'][a-zA-Z][\\w]*[\\']|[\\[][a-zA-Z][\\w]*[\\]])+(\\!\\!([a-zA-Z][\\w]*|[\\'][a-zA-Z][\\w]*[\\']|[\\[][a-zA-Z][\\w]*[\\]]))*[\"])+[\\)]))";
    protected final String REGEX_STR_VARDEC = "([a-zA-Z]\\w*)\\:(([a-zA-Z]\\w*)|(\"[\\w\\s\\?\\!]*\"))";
    protected final String REGEX_DEBUG = "([a-zA-Z]\\w*)|(\"([a-zA-Z][\\w\\s]*)\")";
    protected final String REGEX_EXIT = "[0]|[1]";
    protected final String REGEX_LOOP = "(true)|\\d+";
    protected final String REGEX_SET = "^([a-zA-Z][\\w]*)[\\:]([\"][a-zA-Z][\\w]*[\"]|[a-zA-Z][\\w*])([\\,]([\"][a-zA-Z][\\w]*[\"]|[a-zA-Z][\\w]*))*";
    protected final String REGEX_ACTION = "([a-zA-Z]\\w*\\:)((-)|([sn][a-zA-Z]\\w*)([\\,]([sn][a-zA-Z]\\w*))*)(\\:\\d*)";
    protected final String REGEX_ACTION_CALL = "([a-zA-Z]\\w*\\:)((-)|([a-zA-Z]\\w*)|(\"([\\w\\s])*\")|\\d*)(\\,((-)|([a-zA-Z]\\w*)|(\"([\\w\\s])*\")|\\d*))*";
    protected final String REGEX_VALIDE_NAME = "([a-zA-Z][\\w]*)";
    protected final String REGEX_VALIDE_NUMBER = "^[-]?[0-9]+$";
    protected final String CALCULATABLE = "^(([-]?([0-9]))*|([-]?([a-zA-Z]+[a-zA-Z0-9])))*(?:[-+*/][-]?[a-zA-Z0-9]+)*$";



}
