<!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="/AdminTemplates/user/${sessionScope.currentUser.photo}" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${sessionScope.currentUser.fullname}</a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>
                Report
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Report Chart</p>
                </a>
              </li>
            </ul>
          </li>
          
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Table Edition
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="editionUser" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>User</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="editionProduct" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Product</p>
                </a>
              </li>
            </ul>
            
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="editionAssess" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Assess About Product</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="editionDiscount" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Product Discount</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="editionOrders" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Orders</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-header">Admin</li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-envelope"></i>
              <p>
                Feed Back
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Product Assess</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Feed Back From User</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
			  <a href="#" class="nav-link">
			    <i class="nav-icon far fa-plus-square"></i>
			    <p>
			      Admin Account
			      <i class="fas fa-angle-left right"></i>
			    </p>
			  </a>
			  <ul class="nav nav-treeview">
			    <li class="nav-item">
			      <a href="#" class="nav-link">
			        <i class="far fa-circle nav-icon"></i>
			        <p>
			          Login & Register v1
			          <i class="fas fa-angle-left right"></i>
			        </p>
			      </a>
			      <ul class="nav nav-treeview">
			        <li class="nav-item">
			          <a href="" class="nav-link">
			            <i class="far fa-circle nav-icon"></i>
			            <p>Register Admin Account</p>
			          </a>
			        </li>
			        <li class="nav-item">
			          <a href="" class="nav-link">
			            <i class="far fa-circle nav-icon"></i>
			            <p>Recover Account Deleted</p>
			          </a>
			        </li>
			      </ul>
			
			    </li>
			  </ul>
			</li>
              
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>