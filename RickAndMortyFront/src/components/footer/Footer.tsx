import About from '../about/About';
import Github from '../../images/Github.png';
import Linkedin from '../../images/Linkedin.png';
import './Footer.css';

export default function Footer(): JSX.Element {
  return (
    <footer className="d-flex justify-content-between footer">
      <div className="ms-2">
        <About />
      </div>
      <div className="text align-self-center">
        <p>Designed and built with 💚</p>
      </div>
      <div className="mb-2 mt-2">
        <img src={Github} alt="Github" className="gitLogo" />
        <img src={Linkedin} alt="Linkedin" className="linkLogo" />
      </div>
    </footer>
  );
}
