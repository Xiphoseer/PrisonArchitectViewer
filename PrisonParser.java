import java.io.*;

class PrisonParser{
  private BufferedReader br;
  public String cLine = null;
  public int cursorPos = 0;
  
  public PrisonParser(BufferedReader savegame){
    br = savegame;
    try 
    {
      cLine = br.readLine();
    }
    catch (Exception e) 
    {
      cLine = null;
    }
  }
  
  public String nextExpression(){
    if (cLine != null){
      StringBuilder expression = new StringBuilder("");
      boolean expstart = false;
      boolean inString = false;
      boolean expfin = false;
      while (expfin == false) 
      {
        if (cLine.length() > cursorPos) 
        {
          char c = cLine.charAt(cursorPos);
          if (Character.isWhitespace(c)) 
          {
            if (expstart && inString) 
            {
              expression.append(c);
            }else if(expstart){
              expfin = true;
            }
          }else if(c == '"'){
            if (!expstart) 
            {
              inString = true;
              expstart = true;
            }else if(expstart && inString){
              expfin = true;
            }else{
              expression.append('"'); 
            }
          }else{
            expression.append(c);
            if (!expstart) 
            {
              expstart = true;
            }
          }
          cursorPos++;
        }else{
          try 
          {
            cLine = br.readLine();
          }
          catch (Exception e) 
          {
            cLine = null;
          }
          cursorPos = 0;
          if (expstart) 
          {
            expfin = true;
          }
        }
      }
      return expression.toString();
    }else{
      return null;
    }
  }
  
}