import functools


class NoNumbersAllowedError(Exception):
    def __init__(self):
        self.message = "No Numbers Allowed."

    def __str__(self):
        return self.message


def upCase(func=None):
    @functools.wraps(func)
    def upCaseWrapper():
        ret = func()
        try:
            if float(ret):
                raise NoNumbersAllowedError
        except NoNumbersAllowedError as err:
            print(f'{err} {ret} is a number.')
        except ValueError:
            return ret.upper()
    return upCaseWrapper
