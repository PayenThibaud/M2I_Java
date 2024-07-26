Exercices - grid
Exercice01
A partir du code ci-dessous, tentez de récréer la même grille que sur la photo.



body {
  background-color: #fff;
  color: #333;
  font: 1.2em / 1.5 Helvetica Neue, Helvetica, Arial, sans-serif;
  padding: 1em;
  margin: 0;
}

.grid > * {
  border-radius: 0.5em;
  color: #fff;
  padding: 0.5em;
}

.grid {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 100px 100px 100px;
  gap: 10px;
}

.item1 {
  background-color: rgb(74 102 112 / 70%);
  border: 5px solid rgb(74 102 112 / 100%);
}

.item2 {
  background-color: rgb(214 162 173 / 70%);
  border: 5px solid rgb(214 162 173 / 100%);
}

.grid {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 100px 100px 100px;
  gap: 10px;
}

/* à compléter */
.item1 {
}

/* à compléter */
.item2 {
}
<div class="grid">
  <div class="item1">One</div>
  <div class="item2">Two</div>
</div>
Exercice02
A partir du code ci-dessous, tentez de récréer la même grille que sur la photo.



<div class="container">
  <div class="card">
    <img src="balloons1.jpg" alt="a single red balloon" />
    <ul class="tags">
      <li>balloon</li>
      <li>red</li>
      <li>sky</li>
      <li>blue</li>
      <li>Hot air balloon</li>
    </ul>
  </div>
  <div class="card">
    <img src="balloons2.jpg" alt="balloons over some houses" />
    <ul class="tags">
      <li>balloons</li>
      <li>houses</li>
      <li>train</li>
      <li>harborside</li>
    </ul>
  </div>
  <div class="card">
    <img src="balloons3.jpg" alt="close-up of balloons inflating" />
    <ul class="tags">
      <li>balloons</li>
      <li>inflating</li>
      <li>green</li>
      <li>blue</li>
    </ul>
  </div>
  <div class="card">
    <img src="balloons4.jpg" alt="a balloon in the sun" />
    <ul class="tags">
      <li>balloon</li>
      <li>sun</li>
      <li>sky</li>
      <li>summer</li>
      <li>bright</li>
    </ul>
  </div>
</div>
body {
  background-color: #fff;
  color: #333;
  font: 1.2em / 1.5 Helvetica Neue, Helvetica, Arial, sans-serif;
  padding: 1em;
  margin: 0;
}

.card {
  display: grid;
  grid-template-rows: 200px min-content;
}

.card > img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.tags {
  margin: 0;
  padding: 0;
  list-style: none;
}

.tags > * {
  background-color: #999;
  color: #fff;
  padding: 0.2em 0.8em;
  border-radius: 0.2em;
  font-size: 80%;
  margin: 5px;
}

/* à compléter */
.container {
}

/* à compléter */
.tags {
}