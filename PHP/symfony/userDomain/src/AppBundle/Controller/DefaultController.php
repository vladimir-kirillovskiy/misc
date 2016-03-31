<?php

namespace AppBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class DefaultController extends Controller
{
    /**
     * @Route("/{page}", name="homepage", defaults={"page" = 1})
     */
    public function indexAction($page)
    {

        $records_per_page = 20;     // limit to 20 records per page

        $rep = $this->getDoctrine()
            ->getRepository('AppBundle:Users');


        // get a total count of distinct domain names

        $countsql = "
            SELECT 
                COUNT(DISTINCT RIGHT(email, LENGTH(email)-INSTR(email, '@')))
            FROM 
                users
        ";

        $conn = $this->get('database_connection');
        $count = $conn->fetchColumn($countsql);     // select domains and count of the users
            

        $pages = floor($count / $records_per_page);    
        $pages = ($pages < 1) ? 1:$pages;

        $offset = ($page-1)*$records_per_page;
        $limit = $records_per_page;

        $sql = "
        SELECT 
            RIGHT(email, LENGTH(email)-INSTR(email, '@'))  as domain,
            COUNT(name) as count 
        FROM 
            users
        GROUP BY 
            RIGHT(email, LENGTH(email)-INSTR(email, '@'))
        ORDER BY 
            COUNT(name) DESC
        LIMIT " . $offset . ", " . $limit;

        $domains = $conn->fetchAll($sql);     // select domains and count of the users

        // render view page
        return $this->render('default/index.html.twig', ["domains" => $domains, "pages" => $pages]);
    }
}
