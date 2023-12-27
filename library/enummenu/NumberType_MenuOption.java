package Lin.library.enummenu;
/**
 * public static int INT_NumberType=1, DOUBLE_NumberType=2, FLOAT_NumberType=3;
 * @author MeiChunLo
 *
 */

public enum NumberType_MenuOption
{
   // declare contents of enum type
   INT_NUMBER_TYPE         ( 1, "INT_NumberType" ),
   DOUBLE_NUMBER_TYPE    ( 2, "DOUBLE_NumberType" ),
   FLOAT_NUMBER_TYPE    ( 3, "FLOAT_NumberType");
 
  

   private final int valueIndex; // current menu option
   private final String  numberType; // current menu option
   
   NumberType_MenuOption( int _valueIndex, String _numberType )
   {
      valueIndex = _valueIndex;
      numberType=_numberType;
   } // end MenuOptions enum constructor

   public int getValueIndex()
   {
      return valueIndex;
   } // end method getValue
   
   public String getNumberType()
   {
      return numberType;
   } // end method getNumberType
} // end enum NumberType_MenuOption