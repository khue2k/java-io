package org.example.objectOutputStream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class GameSetting implements Serializable {
    private static final long serialVersionId = 1L;
    private int sound;
    private int bright;
    private String difficultyLevel;
    private String userNote;

}
