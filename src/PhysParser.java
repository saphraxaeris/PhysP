/* Generated By:JavaCC: Do not edit this line. PhysParser.java */
import java.util.*;
import java.io.*;

public class PhysParser implements PhysParserConstants {
  public static void main(String args []) throws ParseException
  {
    try
    {
        PhysParser parser;

        HashMap variables = new HashMap();
                boolean valid = true;

        if (args.length == 0) {
                parser = new PhysParser(System.in);
                }
        else {
                parser = new PhysParser(new java.io.FileInputStream(args[0]));
                }

                while (valid) {
                        valid = parser.read(variables);
                }
    }
        catch (Throwable e)
    {
        System.out.println(e.getMessage());
    }
  }

  static final public boolean read(HashMap variables) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TERMINATE:
      jj_consume_token(TERMINATE);
                  {if (true) return false;}
      break;
    case DEFINE:
    case QUESTION:
    case ID:
    case 37:
    case 38:
      label_1:
      while (true) {
        Statement(variables);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 35:
          jj_consume_token(35);
          break;
        default:
          jj_la1[0] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DEFINE:
        case QUESTION:
        case ID:
        case 37:
        case 38:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_1;
        }
      }
                                     {if (true) return true;}
      break;
    case 0:
      jj_consume_token(0);
            {if (true) return false;}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public void Statement(HashMap variables) throws ParseException {
  Token obj=null, ident=null, attr=null, val=null, msr=null, eql=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DEFINE:
      jj_consume_token(DEFINE);
      ident = jj_consume_token(ID);
      jj_consume_token(AS);
      obj = jj_consume_token(OBJECT);
    if(obj.image.equals("object")) {
          variables.put(ident.image, new PhysPObject());
    }
    else if(obj.image.equals("vector")) {
          variables.put(ident.image, new PhysPVector());
    }
    else {
      System.out.println("Invalid data type.");
    }
      break;
    case ID:
      ident = jj_consume_token(ID);
      jj_consume_token(36);
      attr = jj_consume_token(ATTRIBUTE);
      val = jj_consume_token(DOUBLE);
    if(variables.containsKey(ident.image)) {
          if(variables.get(ident.image) instanceof PhysPObject) {
        PhysPObject physpObject = (PhysPObject) variables.get(ident.image);
        physpObject.setVariable(Double.parseDouble(val.image), attr.image);
                variables.put(ident.image, physpObject);
      }
      else if(variables.get(ident.image) instanceof PhysPVector) {
                PhysPVector physpVector = (PhysPVector) variables.get(ident.image);
        physpVector.setVariable(Double.parseDouble(val.image), attr.image);
                variables.put(ident.image, physpVector);
      }
    }
    else {
      System.out.println("Invalid identifier.");
    }
      break;
    case 37:
      jj_consume_token(37);
      ident = jj_consume_token(ID);
      attr = jj_consume_token(ATTRIBUTE);
    if(variables.containsKey(ident.image)) {
      double result = Double.NaN;
          if(variables.get(ident.image) instanceof PhysPObject) {
        PhysPObject physpObject = (PhysPObject)variables.get(ident.image);
        result = physpObject.getVariable(attr.image);
            variables.put(ident.image, physpObject);
      }
      else if(variables.get(ident.image) instanceof PhysPVector) {
                PhysPVector physpVector = (PhysPVector)variables.get(ident.image);
        result = physpVector.getVariable(attr.image);
                variables.put(ident.image, physpVector);
      }
      if(!Double.isNaN(result)) {
                System.out.println(result);
      }
    }
    else {
      System.out.println("Invalid identifier.");
    }
      break;
    case 38:
      jj_consume_token(38);
      ident = jj_consume_token(ID);
    if(variables.containsKey(ident.image)) {
      variables.remove(ident.image);
    }
    else {
                System.out.println("Invalid identifier.");
    }
      break;
    case QUESTION:
      jj_consume_token(QUESTION);
      ident = jj_consume_token(ID);
      attr = jj_consume_token(ATTRIBUTE);
      eql = jj_consume_token(EQUALLITY);
      val = jj_consume_token(DOUBLE);
    if(variables.containsKey(ident.image)) {
      double result = Double.NaN;
          if(variables.get(ident.image) instanceof PhysPObject) {
        PhysPObject physpObject = (PhysPObject)variables.get(ident.image);
        result = physpObject.getVariable(attr.image);
                variables.put(ident.image, physpObject);
      }
      else if(variables.get(ident.image) instanceof PhysPVector) {
                PhysPVector physpVector = (PhysPVector)variables.get(ident.image);
        result = physpVector.getVariable(attr.image);
                variables.put(ident.image, physpVector);
      }

      if(!Double.isNaN(result)) {
                if(eql.image.equals("equal to")) {
                        if(result == Double.parseDouble(val.image)) {
                                System.out.println("True.");
                }
                else {
                                System.out.println("False.");
                }
                }
                else if (eql.image.equals("not equal to")) {
                        if(result == Double.parseDouble(val.image)) {
                                System.out.println("False.");
                }
                else {
                                System.out.println("True.");
                }
                }
                else if (eql.image.equals("greater than")) {
                  if(result > Double.parseDouble(val.image)) {
                                System.out.println("True.");
                }
                else {
                                System.out.println("False.");
                }
                }
                else if (eql.image.equals("less than")) {
                  if(result < Double.parseDouble(val.image)) {
                                System.out.println("True.");
                }
                else {
                                System.out.println("False.");
                }
                }
                else if (eql.image.equals("greater than or equal to")) {
                  if(result >= Double.parseDouble(val.image)) {
                                System.out.println("True.");
                }
                else {
                                System.out.println("False.");
                }
                }
                else if (eql.image.equals("less than or equal to")) {
                  if(result <= Double.parseDouble(val.image)) {
                                System.out.println("True.");
                }
                else {
                                System.out.println("False.");
                }
                }
      }
    }
    else {
      System.out.println("Invalid identifier.");
    }
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public PhysParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x2001040,0x2401041,0x2001040,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x8,0x60,0x60,0x60,};
   }

  /** Constructor with InputStream. */
  public PhysParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public PhysParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new PhysParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public PhysParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new PhysParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public PhysParser(PhysParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(PhysParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[39];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 39; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
