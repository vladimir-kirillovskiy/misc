<?php

namespace App\Providers;

use Illuminate\Support\ServiceProvider;
use View;

class ComposerServiceProvider extends ServiceProvider
{
    /**
     * Bootstrap the application services.
     *
     * @return void
     */
    public function boot()
    {
        // we set ProfileComposer available only to profile view
        // View::composer('pages.profile', 'App\Http\ViewComposers\ProfileComposer');
        // View::composer(['pages.settings', 'pages.profile'], 'App\Http\ViewComposers\ProfileComposer');
        View::creator(['pages.settings', 'pages.profile'], 'App\Http\ViewComposers\ProfileComposer');
    }

    /**
     * Register the application services.
     *
     * @return void
     */
    public function register()
    {
        //
    }
}
