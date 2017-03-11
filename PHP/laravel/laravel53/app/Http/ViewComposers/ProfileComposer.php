<?php
  namespace App\Http\ViewComposers;
  use Illuminate\View\View;

  class ProfileComposer {
    public function create(View $view) {
      $view->with('married', random_int(0, 1));
    }
    // public function compose(View $view) {
    //   $view->with('married', random_int(0, 1));
    // }
  }

?>
