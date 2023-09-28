export interface EpisodesInterface {
  _id: number;
  name: string;
  air_date: string;
  episode: string;
  characters: charactersType[];
}

type charactersType = {
  id: number;
  name: string;
};
