package character.domain.hero;

import character.domain.hero.Name;
import character.domain.hero.abilities.AbilityTypes;
import character.domain.hero.classes.ClassTypes;
import character.domain.hero.experience.ExperiencePoints;
import character.domain.hero.health.HealthPoints;
import character.domain.hero.level.Level;
import character.domain.hero.races.RaceTypes;

import java.util.Map;

public class HeroFactory {

        public Hero create(Name name, Map<AbilityTypes, Integer> abilitiesData, RaceTypes race, ClassTypes heroClass) {
                Level level = new Level(1);
                ExperiencePoints xp = new ExperiencePoints(0,300);
        }


}
