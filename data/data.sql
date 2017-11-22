insert into films_proj(id,title,year,director,review) select id, title, year, director, review from films;
UPDATE films_proj SET duration = 40 + (200 - 40) * RAND();
update films_proj set credits = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam feugiat.';
commit;