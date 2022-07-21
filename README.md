<h1>Academia</h1>
<p>An E-Learning Platform</p>

<h2>Language Used</h2>
<ul>
    <li>Java
</ul>

<h2>TOOLS USED</h2>
<ul>
    <li>Java
    <li>Android Studio
    <li>Adobe XD
    <li>Figma
    <li>Lottiefiles
</ul>

```java
<!-- NavigationView Snippet -->

    private void navigationDrawer() {

        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        hamburgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }
```

![home scen](https://user-images.githubusercontent.com/82509653/147914683-92fdc6b4-a338-4379-b4c2-e2c8d8872256.png)
![Academia app](https://user-images.githubusercontent.com/82509653/147914685-d084aee4-61c6-492b-a227-db1c2935cc6c.png)
![splash_academia](https://user-images.githubusercontent.com/82509653/147914694-ee8a2288-94e3-41eb-ada2-f0e95bf187f6.png)
