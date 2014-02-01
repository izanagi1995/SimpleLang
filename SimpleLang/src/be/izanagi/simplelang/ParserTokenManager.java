/* Generated By:JJTree&JavaCC: Do not edit this line. ParserTokenManager.java */
package be.izanagi.simplelang;
import java.io.FileInputStream;
import java.util.Stack;
import be.izanagi.simplelang.interpretation.Interpreter;
import be.izanagi.simplelang.astprint.ASTPrinter;

/** Token Manager. */
public class ParserTokenManager implements ParserConstants
{
    int count_comm = 1;

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x40000000L) != 0L)
            return 10;
         if ((active0 & 0x33400L) != 0L)
         {
            jjmatchedKind = 19;
            return 23;
         }
         if ((active0 & 0x800L) != 0L)
         {
            jjmatchedKind = 19;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0x1800L) != 0L)
            return 23;
         if ((active0 & 0x32400L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 1;
            return 23;
         }
         return -1;
      case 2:
         if ((active0 & 0x30400L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 2;
            return 23;
         }
         if ((active0 & 0x2000L) != 0L)
            return 23;
         return -1;
      case 3:
         if ((active0 & 0x20400L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 3;
            return 23;
         }
         if ((active0 & 0x10000L) != 0L)
            return 23;
         return -1;
      case 4:
         if ((active0 & 0x20000L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 4;
            return 23;
         }
         if ((active0 & 0x400L) != 0L)
            return 23;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 40:
         jjmatchedKind = 28;
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 41:
         return jjStopAtPos(0, 27);
      case 42:
         return jjStopAtPos(0, 31);
      case 43:
         return jjStopAtPos(0, 29);
      case 44:
         return jjStopAtPos(0, 9);
      case 45:
         return jjStartNfaWithStates_0(0, 30, 10);
      case 47:
         return jjStopAtPos(0, 32);
      case 60:
         jjmatchedKind = 26;
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 61:
         jjmatchedKind = 15;
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 62:
         jjmatchedKind = 25;
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x400L);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 61:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(1, 21);
         else if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(1, 22);
         else if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(1, 23);
         else if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(1, 24);
         break;
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000L);
      case 102:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(1, 11, 23);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 111:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(1, 12, 23);
         break;
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(2, 13, 23);
         break;
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 99:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(3, 16, 23);
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 23);
         break;
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(5, 17, 23);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 23;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 23:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 45)
                     jjCheckNAdd(13);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 18)
                        kind = 18;
                     jjCheckNAddTwoStates(9, 10);
                  }
                  else if (curChar == 34)
                     jjCheckNAdd(15);
                  else if (curChar == 45)
                     jjCheckNAdd(10);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 45)
                     jjCheckNAdd(13);
                  break;
               case 9:
                  if (curChar == 45)
                     jjCheckNAdd(10);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddTwoStates(9, 10);
                  break;
               case 12:
                  if (curChar == 45)
                     jjCheckNAdd(13);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(0, 2);
                  break;
               case 14:
                  if (curChar == 34)
                     jjCheckNAdd(15);
                  break;
               case 16:
                  if (curChar == 45)
                     jjCheckNAdd(17);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 7);
                  break;
               case 18:
                  if (curChar == 32)
                     jjCheckNAddTwoStates(18, 19);
                  break;
               case 20:
                  if (curChar == 45)
                     jjCheckNAdd(21);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(8, 12);
                  break;
               case 22:
                  if (curChar == 34 && kind > 20)
                     kind = 20;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 23:
               case 11:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(0, 2);
                  break;
               case 2:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                     jjCheckNAddStates(0, 2);
                  }
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 7;
                  else if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                     jjCheckNAddStates(0, 2);
                  }
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 116 && kind > 14)
                     kind = 14;
                  break;
               case 3:
                  if (curChar == 103 && kind > 14)
                     kind = 14;
                  break;
               case 4:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 5:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 6:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 7:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 8:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 15:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                     jjCheckNAddStates(3, 7);
                  break;
               case 19:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                     jjCheckNAddStates(8, 12);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 23 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 40:
         return jjMoveStringLiteralDfa1_1(0x40L);
      case 41:
         return jjMoveStringLiteralDfa1_1(0x80L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_1(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 41:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(1, 7);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   11, 12, 13, 15, 16, 17, 18, 22, 18, 19, 20, 21, 22, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, "\54", 
"\167\150\151\154\145", "\151\146", "\144\157", "\145\156\144", null, "\75", "\146\165\156\143", 
"\162\145\164\165\162\156", null, null, null, "\75\75", "\41\75", "\76\75", "\74\75", "\76", "\74", "\51", 
"\50", "\53", "\55", "\52", "\57", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "IN_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x1fffffe01L, 
};
static final long[] jjtoSkip = {
   0x1feL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[23];
private final int[] jjstateSet = new int[46];
private final StringBuilder jjimage = new StringBuilder();
private StringBuilder image = jjimage;
private int jjimageLen;
private int lengthOfMatch;
protected char curChar;
/** Constructor. */
public ParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 23; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   switch(curLexState)
   {
     case 0:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 8)
       {
          jjmatchedKind = 8;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
           SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 6 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
        count_comm++;
         break;
      case 7 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
          count_comm--;
    if(count_comm==0)
    {
      SwitchTo(DEFAULT);
    }
         break;
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
