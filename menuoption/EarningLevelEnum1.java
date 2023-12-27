package Lin.polymorphism.employee.menuoption;

import java.awt.Color;

public enum EarningLevelEnum1 {
    LevelA(15, "Level A", "A", new Color(255, 0, 0)),
    LevelB(8, "Level B", "B", new Color(0, 255, 0)),
    LevelC(0, "Level C", "C", new Color(0, 0, 255)),
    UNIT(1000,"Thousand", "", new Color(255, 255, 255)),
    MAX_WORKED_HOURS(80, "max worked hours", "", new Color(255, 255, 255));
	
    private final int valueOption; // current menu value
    private final String levelOrUnitType; // current menu level-type or unit considered
    private final String levelCharacter; // current menu level-Character represented
    private final Color indexColor;

    EarningLevelEnum1(int _valueOption, String _levelOrUnitType, String _levelCharacter, Color _indexColor) {
        valueOption = _valueOption;
        levelOrUnitType = _levelOrUnitType;
        levelCharacter = _levelCharacter;
        indexColor = _indexColor;
    } // end EarningLevelEnum constructor

    public int getValue() {
        return valueOption;
    } // end method getValue

    public String getLevelType() {
        return levelOrUnitType;
    } // end method getLevelType

    public String getLevelCharacter() {
        return levelCharacter;
    } // end method getLevelCharacter

    public Color getColor() {
        return indexColor;
    } // end method getColor

} //end enum EarningLevelEnum