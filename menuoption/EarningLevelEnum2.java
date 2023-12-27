package Lin.polymorphism.employee.menuoption;

import java.awt.Color;

public enum EarningLevelEnum2 {
    LevelA(15, "Level A", "A", new Color(255, 0, 0));

    private final int value; // current menu value
    private final String levelOrUnitType; // current menu level-type or unit considered
    private final String levelCharacter; // current menu level-Character represented
    private final Color indexColor;

    EarningLevelEnum2(int valueOption, String _levelOrUnitType, String _levelCharacter, Color _indexColor) {
        value = valueOption;
        levelOrUnitType = _levelOrUnitType;
        levelCharacter = _levelCharacter;
        indexColor = _indexColor;
    }
}