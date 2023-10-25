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

export type CharctersOriginType = {
  id: number;
  name: string;
};

export enum Gender {
  Male = 'Male',
  Female = 'Female',
  Genderless = 'Genderless',
  Unknown = 'Unknown',
}

export enum Status {
  Alive = 'Alive',
  Dead = 'Dead',
  Unknown = 'unknown',
}

export enum Species {
  Human = 'Human',
  Alien = 'Alien',
  Humanoid = 'Humanoid',
  Cronenberg = 'Cronenberg',
  Unknown = 'Unknown',
}

export enum Type {
  Empty = '',
  Parasite = 'Parasite',
  HumanWithAntennae = 'Human with antennae',
  FishPerson = 'Fish-Person',
  CatPerson = 'Cat-Person',
  Robot = 'Robot',
}
