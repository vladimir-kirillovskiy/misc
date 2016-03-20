<?php

namespace AppBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

use AppBundle\Entity\User;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\BirthdayType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;

class DefaultController extends Controller
{
    /**
     * @Route("/", name="register")
     */
    public function indexAction(Request $request)
    {
        $user = new User();

        /*
            Пока я не совсем разобрался с поддержкой русского языка при создании форм.
            Кажется ее нужно делать отдельно как multi language.
        */
        $form = $this->createFormBuilder($user)
            ->add('last_name', TextType::class, 
                array("attr" => array("class" => "form-control")))
            ->add('first_name', TextType::class, 
                array("attr" => array("class" => "form-control")))
            ->add('patronym', TextType::class, 
                array("attr" => array("class" => "form-control")))
            ->add('email', TextType::class, 
                array("attr" => array("class" => "form-control")))
            ->add('dob', BirthdayType::class, 
                array("attr" => array("class" => "dob-form-control")))
            ->add('gender', ChoiceType::class, 
                array("attr" => array("class" => "form-control"), 
                    "choices" => array('мужской' => true, 'женский' => false )))
            ->add('Save', SubmitType::class, 
                array("attr" => array("label" => "Create", "class" => "btn btn-primary reg-button")))
            ->getForm();

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) 
        {
            $last_name = $form['last_name']->getData();
            $first_name = $form['first_name']->getData();
            $patronym = $form['patronym']->getData();
            $email = $form['email']->getData();
            $dob = $form['dob']->getData();
            $gender = $form['gender']->getData();

            $user->setLastName($last_name);
            $user->setFirstName($first_name);
            $user->setPatronym($patronym);
            $user->setEmail($email);
            $user->setDob($dob);
            $user->setGender($gender);

            $em = $this->getDoctrine()->getManager();

            $em->persist($user);
            $em->flush();

            $this->addFlash("notice", "User Added");

            return $this->redirectToRoute('userlist');
        }
        return $this->render('default/register.html.twig', array("form" => $form->createView()));
    }

     /**
     * @Route("/list/{page}", defaults={"page" = 1}, name="userlist")
     */
    public function listAction($page)
    {
        $records_per_page = 5;

        $rep = $this->getDoctrine()
            ->getRepository('AppBundle:User');


        // get a total count of users
        $count = $rep->createQueryBuilder('u')
            ->select('count(u.id)')
            ->getQuery()
            ->getSingleScalarResult();

        $pages = ceil($count / $records_per_page);    

    
        $users = $rep->findBy(
            array(),                        //creteria
            array(),                        // order by
            $records_per_page,              // limit
            ($page-1)*$records_per_page     // offset
        );

        return $this->render('default/list.html.twig', ["users" => $users, "pages" => $pages ]);
    }
}
