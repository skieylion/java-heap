module modulelesson2 {
    requires modulelesson3;
    requires static modulelesson4;
    provides package3.CubeProvider with package2.CubeMinusProvider, package2.CubePlusProvider;
}