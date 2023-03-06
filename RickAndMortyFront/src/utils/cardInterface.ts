export interface CardInterface {
  id: string | number;
  name: string;
  status: string;
  origin: {
    name: string;
    url: string;
  };
  image: string;
}
