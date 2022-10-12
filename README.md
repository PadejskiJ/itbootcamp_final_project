# itbootcamp_final_project
testing demo site, URL  https://vue-demo.daniel-avellaneda.com/home


Projekat: Testiranje aplikacije https://vue-demo.daniel-avellaneda.com/ 

Zadatak:
Kreirati repozitorijum na github-u pod nazivom itbootcamp_final_project. Projekat mora da ima komitove nakon svake završene celine, ne samo na kraju.

Podesite projekat tako da u isti dodate validnu verziju chromedriver-a, a takođe dodati i testNG i selenium biblioteke u pom.xml.
Prilikom izrade projekta, potrebno je jasno odvojiti pakete za stranice i testove. Primer:
    • pages - gde cuvate sve klase koje su page-evi
    • tests - gde cuvate sve klase koje su testovi

Preporuka je da sav kod i poruke komitova budu na engleskom.

Obavezno korišćenje wait-era koji će čekati otvaranje dijaloga ili slična učitavanja.

Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
    • baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
    • beforeClass - gde se podesava drajver sa implicitnim cekanjem i cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
    • aftterClass - gde se gasi stranica
    • beforeMethod - gde se pre svakog testa ucitava baseUrl stranica

Navedene su samo obavezne assertacije, po potrebi dodajte dodatne.

Testove podeliti po klasama:
Login Tests

Test #1: Visits the login page
assert:  
    • Verifikovati da se u url-u stranice javlja ruta /login


Test #2: Checks input types
assert: 
    • Verifikovati da polje za unos emaila za atribut type ima vrednost email
    • Verifikovati da polje za unos lozinke za atribut type ima vrednost password


Test #3: Displays errors when user does not exist
Podaci: random email i password koristeći faker libarary
asssert: 
    • Verifikovati da greska sadrzi poruku User does not exists
    • Verifikovati da se u url-u stranice javlja /login ruta 

Test #4: Displays errors when password is wrong
Podaci: random email i password koristeći faker libarary
asssert: 
    • Verifikovati da greska sadrzi poruku Wrong password
    • Verifikovati da se u url-u stranice javlja /login ruta 

Test #5: Login
Podaci: 
    • email: admin@admin.com
    • password: 12345
asssert: 
    • Verifikovati da se u url-u stranice javlja /home ruta 

Test #6: Logout
assert: 
    • Verifikovati da je dugme logout vidljivo na stranici 
    • Verifikovati da se u url-u stranice javlja /login ruta 
    • Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u stranice javlja /login ruta 
Signup Tests

Test #1: Visits the signup page
assert: 
    • Verifikovati da se u url-u stranice javlja /signup ruta 

Test #2: Checks input types
assert: 
    • Verifikovati da polje za unos emaila za atribut type ima vrednost email
    • Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    • Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password

Test #3: Displays errors when user already exists
Podaci: 
    • name: Test Test
    • email: admin@admin.com
    • password: 123654
    • confirm password: 123654
assert: 
    • Verifikovati da greska sadrzi poruku E-mail already exists
    • Verifikovati da se u url-u stranice javlja /signup ruta 

Test #4: Signup
Podaci: 
    • name: Ime i prezime polaznika
    • email template: ime.prezime@itbootcamp.rs
    • password: 12346
    • confirm password: 123456
assert: 
    • Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account

etWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));

Admin Cities Tests
CitiesBtn  //*[@id="app"]/div[3]/div[1]/a[1]

Test #1: Visits the admin cities page and list cities
Podaci: 
    • admin email: admin@admin.com
    • admin password: 12345
assert: 
    • Verifikovati da se u url-u stranice javlja /admin/cities ruta 
    • Verifikovati postojanje logut dugmeta


Test #2: Create new city
Podaci: random grad korisćenjem faker library-ja
assert: 
    • Verifikovati da poruka sadrzi tekst Saved successfully

Test #3: Edit city
Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
assert: 
    • Verifikovati da poruka sadrzi tekst Saved successfully


Test #4: Search city
Podaci: editovani grad iz testa #3
assert: 
    • Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage



Test #5: Delete city
Podaci: editovani grad iz testa #3
assert: 
    • U polje za pretragu uneti staro ime grada
    • Sacekati da broj redova u tabeli bude 1
    • Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    • Kliknuti na dugme Delete iz prvog reda
    • Sacekati da se dijalog za brisanje pojavi
    • Kliknuti na dugme Delete iz dijaloga
    • Sacekati da popu za prikaz poruke bude vidljiv
    • Verifikovati da poruka sadrzi tekst Deleted successfully

Auth Routes Tests

Test #1: Forbids visits to home url if not authenticated
assert: 
    • Ucitati /home stranu kada korisnik nije ulogovan
    • Verifikovati da se u url-u stranice javlja ruta /login

Test #2: Forbids visits to profile url if not authenticated
assert: 
    • Ucitati /profile stranu
    • Verifikovati da se u url-u stranice javlja ruta /login

Test #3: Forbids visits to admin cities url if not authenticated
assert: 
    • Ucitati /admin/cities stranu
    • Verifikovati da se u url-u stranice javlja ruta /login

Test #4: Forbids visits to admin users url if not authenticated
assert: 
    • Ucitati /admin/users stranu
    • Verifikovati da se u url-u stranice javlja ruta /login

Locale Tests

Test #1: Set locale to ES
assert: 
    • Postaviti jezik na ES
    • Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje

Test #2: Set locale to EN
assert: 
    • Postaviti jezik na EN
    • Verifikovati da se na stranici u hederu javlja tekst Landing

Test #3: Set locale to FR
assert: 
    • Postaviti jezik na FR
    • Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage



Profile Tests 
Test #1: Edits profile
Podaci: random podaci korišćenjem faker library-ja
assert: 
    • Verifikovati da je prikazana poruka Profile saved successfuly
    • Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
