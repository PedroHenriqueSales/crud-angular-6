import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDatailComponent } from './user-datail.component';

describe('UserDatailComponent', () => {
  let component: UserDatailComponent;
  let fixture: ComponentFixture<UserDatailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserDatailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDatailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
