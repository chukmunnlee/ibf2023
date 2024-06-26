import { inject } from "@angular/core";
import { ActivatedRoute, ActivatedRouteSnapshot, CanActivateFn, CanDeactivateFn, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { PolarbearComponent } from "./views/polarbear.component";

export const enterPolarBear: CanActivateFn =
  (route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
      : boolean | UrlTree | Promise<boolean | UrlTree> | Observable<boolean | UrlTree>  => {
    return confirm('Are you sure you wish to see the polar bears?')
  }

  export const leavePolarBear: CanDeactivateFn<PolarbearComponent> =
  (comp: PolarbearComponent, route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
      : boolean | UrlTree | Promise<boolean | UrlTree> | Observable<boolean | UrlTree>  => {

    const router = inject(Router)

    console.info('>>> form dirty: ', comp.isFormDirty())

    if (comp.isFormDirty())
      return confirm('You have not saved your form. Are you sure?')

    return router.parseUrl('/dog/mastiff')
  }
