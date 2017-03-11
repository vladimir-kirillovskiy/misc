<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\User;

class UserController extends Controller
{
    //
    public function index() {

      $users = User::paginate(10);

      // using blade for a view
      return view('admin.users.index', compact('users')); // view location, parametor
    }


    public function create() {
      return view('admin.users.create');
    }

    public function store(Request $request) {
      User::create($request->all());
      return 'success';
    }
}
