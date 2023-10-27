export interface CharactersInterface {
  id: number;
  name: string;
  status: Status;
  species: Species;
  type: Type;
  gender: Gender;
  image: string;
  origin: CharctersOriginType;
  location: number[];
  episode: number[];
}
export interface InitialStateCharactersInterface {
  characters: CharactersInterface[];
  filterCharacters: CharactersInterface[];
}

type CharctersOriginType = {
  id: number;
  name: string;
};

enum Gender {
  Male = 'Male',
  Female = 'Female',
  Genderless = 'Genderless',
  Unknown = 'Unknown',
}
enum Status {
  Alive = 'Alive',
  Dead = 'Dead',
  Unknown = 'unknown',
}

enum Species {
  Human = 'Human',
  Alien = 'Alien',
  Humanoid = 'Humanoid',
  Cronenberg = 'Cronenberg',
  Unknown = 'Unknown',
}

enum Type {
  Empty = '',
  Parasite = 'Parasite',
  HumanWithAntennae = 'Human with antennae',
  FishPerson = 'Fish-Person',
  CatPerson = 'Cat-Person',
  Robot = 'Robot',
}
