<?php

// php bin/console server:start 
// php bin/console server:stop 
// php bin/console server:run 


//  Beware that annotation blocks start with /**, whereas regular PHP comments start with /*.

// routing annotation block
/**
 * @Route("/", name="homepage")
 */

/*
* Block comment
*
*/


/* twig 

{{ ... }}
Prints the content of a variable or the result of evaluating an expression;
{% ... %}
Controls the logic of the template; it is used for example to execute for loops and if statements.
{# ... #}
Allows including comments inside templates. Contrary to HTML comments, they aren't included in the rendered template.

*/


// Doctrine 
// http://symfony.com/doc/current/book/doctrine.html

// create DB
// php bin/console doctrine:database:create

// php bin/console doctrine:database:drop --force
// php bin/console doctrine:database:create

// generate entity
// php bin/console doctrine:generate:entity