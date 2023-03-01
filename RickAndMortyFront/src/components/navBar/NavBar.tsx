import './NavBar.css';

export default function NavBar() {
  return (
    <nav className="navBar">
      <img src="logo" alt="logo" />
      <div>
        <p>Name</p>
      </div>
      <div className='navProfile'>
        <div>
          <p>Characters</p>
        </div>
        <div>
          <p>Locations</p>
        </div>
        <div>
          <p>Episodes</p>
        </div>
        <div>
          <img src="profile" alt="profile" />
        </div>
      </div>
    </nav>
  );
}
