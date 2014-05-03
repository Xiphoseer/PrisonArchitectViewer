import java.util.*;

public class PrisonData{
  //Enums
  
  //General
  public String version = "Unknown";         //Prison Architect Version, e.g.: alpha-19
  public int NumCellsX = 100;                //Width of the Map
  public int NumCellsY = 80;                 //Height of the Map
  public int OriginX = 0;                    //Original top left corner, X coordinate
  public int OriginY = 0;                    //Original top left corner, Y coordinate
  public int OriginW = 100;                  //Original width of the Map
  public int OriginH = 80;                   //Original height of the Map
  public int TimeIndex = 0;                  //Ingame Time (Savegame file has '.' at the end)
  public int RandomSeed = 14338;             //Random Seed
  public int SecondsPlayed = 0;              //Seconds played
  public int ObjectIdNext = 0;               //Next unique ID to be used by the Game
  public boolean EnabledElectricity = true;  //Electricity enabled
  public boolean EnabledWater = true;        //Water enabled
  public boolean EnabledFood = true;         //Food enabled
  public boolean EnabledMisconduct = true;   //Misconduct enabled
  public boolean EnabledDecay = true;        //Decay of Prison enabled
  public boolean EnabledVisibility = true;   //Fog of War enabled
  public boolean GenerateForests = false;    //Forests enabled
  public boolean EnabledIntake = true;       //Continuos intake
  public boolean ObjectsCentreAligned = true; //???;
  public boolean EnabledGangs = false;        //Might have been removed
  public int FoodQuantity = 3;               //Food Quality   
  public int FoodVariation = 3;              //Food Variety
  public int BioVersions = 4;                //???
  public pa_Time IntakeNext = new pa_Time(1919); //Time for next Arrival of Prisoners
  public int IntakeNumPrisoners = 8;             //Amount of prisoners arriving
  public boolean IntakeReqMin = false;           //Intake of Minimum Security allowed
  public boolean IntakeReqNormal = false;        //Intake of Normal Security allowed
  public boolean IntakeReqMax = false;           //Intake of Maximum Security allowed
  public boolean ImmediateMaterials = true;      //some Materials are delivered instantly
  //Cells
  public ArrayList<pa_Cell> Cells = new ArrayList<pa_Cell>(); //List of ALL cells/tiles on the Map
  public ArrayList<pa_Object> Objects = new ArrayList<pa_Object>(); 
}